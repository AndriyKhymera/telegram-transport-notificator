package transport;

import com.google.transit.realtime.GtfsRealtime;

import java.io.IOException;
import java.net.URL;

public class ProtocolBuff {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://track.ua-gis.com/gtfs/lviv/vehicle_position");
        GtfsRealtime.FeedMessage feed = GtfsRealtime.FeedMessage.parseFrom(url.openStream());
        for (GtfsRealtime.FeedEntity entity : feed.getEntityList()) {
            if (entity.getVehicle().getTrip().getRouteId().equals("982")){
                System.out.println("*****************************");
                System.out.println(entity);
                System.out.println("*****************************");
            }
        }
    }

}
