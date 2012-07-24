/**
 * Created with IntelliJ IDEA.
 * User: ada
 * Date: 7/23/12
 * Time: 8:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class EnterpriseUniverseDownloadSource {

    private static DownloadSource myDownloadSource = new DownloadSource();

    public static DownloadSource getSingletonSource() {
        return new DownloadSource();
    }

    public static class DownloadSource {

        public Object getSource() {
            return null;
        }

        public int getNumberOfDownloadsAvailable() {
            return -1;
        }
    }
}
