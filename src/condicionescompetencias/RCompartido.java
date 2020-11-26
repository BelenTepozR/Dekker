package condicionescompetencias;
import java.util.ArrayList;

public class RCompartido {
    private String rc;
    private Dekker d, d12, d34;
    
    RCompartido(Dekker d,Dekker d12,Dekker d34){
        this.d = d;
        this.d12 = d12;
        this.d34 = d34;
        this.rc = "";
    }

        public String getRc() {
                String aux= " En espera ...";
                aux = rc;        
                return aux;
        }

        public void setRc(String rc) {
               
                this.rc = rc;
        }
      
    
     
    
}
