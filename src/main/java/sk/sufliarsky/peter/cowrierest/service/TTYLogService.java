package sk.sufliarsky.peter.cowrierest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sk.sufliarsky.peter.cowrierest.entity.TTYLog;
import sk.sufliarsky.peter.cowrierest.entity.UnpackedTTYLog;
import sk.sufliarsky.peter.cowrierest.repository.TTYLogRepository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class TTYLogService {

    @Autowired
    TTYLogRepository ttyLogRepository;

    @Value("${cowrie.ttylog.path}")
        private String ttyLogPath;

    private int bytesToInt(byte[] bytes) {
        return ((bytes[0] & 0xFF)
                | (bytes[1] & 0xFF) << 8
                | (bytes[2] & 0xFF) << 16
                | (bytes[3] & 0xFF) << 24);
    }

    private List<UnpackedTTYLog> parsePackedTTYLog(String hash, DataInputStream packedData) throws IOException {
        List<UnpackedTTYLog> result = new ArrayList<>();

        while (packedData.available() > 0) {
            UnpackedTTYLog log = new UnpackedTTYLog();
            log.setHash(hash);
            log.setOp(bytesToInt(packedData.readNBytes(4)));
            log.setTty(bytesToInt(packedData.readNBytes(4)));
            log.setLength(bytesToInt(packedData.readNBytes(4)));
            log.setDir(bytesToInt(packedData.readNBytes(4)));
            log.setSec(bytesToInt(packedData.readNBytes(4)));
            log.setUsec(bytesToInt(packedData.readNBytes(4)));
            log.setData(new String(packedData.readNBytes(log.getLength()), StandardCharsets.UTF_8));
            result.add(log);
        }

        return result;
    }

    public List<UnpackedTTYLog> getTTYLogForSession(String sessionId) {
        ArrayList<UnpackedTTYLog> result = new ArrayList<>();

        List<TTYLog> ttyLogList = ttyLogRepository.findBySession(sessionId);
        ttyLogList.forEach(ttyLog -> {
            String ttyLogRelPath = ttyLog.getTtylog();
            String hash = ttyLogRelPath.substring(ttyLogRelPath.lastIndexOf("/") + 1);
            try {
                File file = new File(ttyLogPath + "/" + hash);
                Path path = Paths.get(file.getAbsolutePath());
                DataInputStream packedData = new DataInputStream(new ByteArrayInputStream(Files.readAllBytes(path)));
                List<UnpackedTTYLog> log = parsePackedTTYLog(hash, packedData);
                result.addAll(log);
            } catch (IOException ex) {
                // TODO
                System.out.println("An error occured processing ttylog " + hash);
                ex.printStackTrace();
            }
        });

        return result;
    }
}
