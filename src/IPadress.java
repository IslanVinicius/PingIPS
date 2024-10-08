import java.net.InetAddress;

public class IPadress{
    String ip;
    public IPadress(String ip){
       this.ip = ip;
    }

    public Boolean isRecheable() throws Exception {
        try{
            InetAddress address = InetAddress.getByName(ip);
            //System.out.println(ip + " - " + address.isReachable(1000)); //TESTAR SE ESTA PINGANDO
            Boolean retorno;
            retorno = address.isReachable(1000);
            if (!retorno){
                retorno = address.isReachable(1000);
            }
            return retorno;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}