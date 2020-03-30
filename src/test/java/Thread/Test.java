package Thread;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.net.*;

/**
 * @author 倪勤华
 * @date 2019-12-16 11:57
 */

public class Test implements Serializable {

    @org.junit.Test
    public void client() {
        try (FileOutputStream fos = new FileOutputStream("test.jpg")) {
            URL url = new URL("https://pics3.baidu.com/feed/8326cffc1e178a829a65e41cca868688a877e8b8.jpeg?token=91e87eefe63c4216b4d2cec1404874cf&s=EDA101D51E5364D6C229C12B03007052");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();//在底层连接上的一个请求
            //urlConnection.setRequestMethod("GET");
            urlConnection.connect();//连接
            InputStream is = urlConnection.getInputStream();

            byte[] bBuf = new byte[5];
            int len;
            while ((len = is.read(bBuf)) != -1) {
                fos.write(bBuf, 0, len);
            }

            is.close();
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void service() {
        try (DatagramSocket datagramSocket = new DatagramSocket(6379)) {
            byte[] bBuf = new byte[1024];//如果bBuf长度太短，会导致接收不完整
            DatagramPacket packet = new DatagramPacket(bBuf, bBuf.length);
            datagramSocket.receive(packet);
            System.out.println(new String(bBuf, 0, bBuf.length));//输出我是UDP报文
            System.out.println(new String(packet.getData(), 0, packet.getLength()));//输出我是UDP报文
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
