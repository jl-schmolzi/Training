package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.*;

public class WebChecker {

    public static void main(String[] args) throws MalformedURLException {
        ExecutorService executor = Executors.newCachedThreadPool();
        WebResourceLastModifiedCallable urlLastModified = new WebResourceLastModifiedCallable(new URL("http://www.tutego.de/index.html"));
        WebResourceLastModifiedCallable urlLastModified2 = new WebResourceLastModifiedCallable(new URL("https://en.wikipedia.org/wiki/Main_Page"));

        Future<ZonedDateTime> t1 = executor.submit(urlLastModified);
        Future<ZonedDateTime> t2 = executor.submit(urlLastModified2);
        try {
//            System.out.println(t1.get(1, TimeUnit.MILLISECONDS));
            System.out.println(t2.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }
        executor.shutdown();
    }

    private static ZonedDateTime getLastModified(URL url) {
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            long dateTime = con.getLastModified();
            con.disconnect();
            return ZonedDateTime.ofInstant( Instant.ofEpochMilli( dateTime ), ZoneId.of( "UTC" ) );
        } catch ( IOException e ) {
            throw new IllegalStateException(e);
        }
    }

    record WebResourceLastModifiedCallable(URL url) implements Callable<ZonedDateTime> {

        @Override
        public ZonedDateTime call() throws Exception {
            return getLastModified(url);
        }
    }
}
