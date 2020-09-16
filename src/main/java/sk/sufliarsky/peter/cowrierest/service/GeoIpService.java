package sk.sufliarsky.peter.cowrierest.service;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.AsnResponse;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.Country;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@Service
public class GeoIpService {

    @Value("${geolite2.asn.file.path}")
    private String geoLite2AsnPath;

    @Value("${geolite2.countries.file.path}")
    private String geoLite2CountriesPath;

    private DatabaseReader asnReader;

    private DatabaseReader countryReader;

    @PostConstruct
    public void initService() {
        File asnDb = new File(geoLite2AsnPath);
        File countryDb = new File(geoLite2CountriesPath);
        try {
            asnReader = new DatabaseReader.Builder(asnDb).build();
            countryReader = new DatabaseReader.Builder(countryDb).build();
        } catch (IOException ex) {
            // TODO: log error
        }
    }

    public Integer getAsnId(String ipAddress) {
        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            AsnResponse response = asnReader.asn(inetAddress);
            return response.getAutonomousSystemNumber();
        } catch (IOException | GeoIp2Exception ex) {
            // TODO: log error
            return null;
        }
    }

    public String getAsnName(String ipAddress) {
        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            AsnResponse response = asnReader.asn(inetAddress);
            return response.getAutonomousSystemOrganization();
        } catch (IOException | GeoIp2Exception ex) {
            // TODO: log error
            return null;
        }
    }

    public Country getCountryInformation(String ipAddress) {
        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            CountryResponse response = countryReader.country(inetAddress);
            return response.getCountry();
        } catch (IOException | GeoIp2Exception ex) {
            // TODO: log error
            return null;
        }
    }
}
