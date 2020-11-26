
package condicionescompetencias;
import javax.swing.JTextArea;

public class Hilo extends Thread{
    private JTextArea area;
    private RCompartido rc;
    private boolean pausado = false;   
    private boolean corriendo = true;   
    private int numHilo;
    private int inic;
    private final static int ini = 100;
    private final static int fin = 2000;
    private Dekker dekker, d;
    private boolean dead = false;
      private boolean block = false;
      
    Hilo(JTextArea area, RCompartido rc, int n, Dekker d, Dekker dp){
        this.area = area;
        this.rc = rc;
        this.setName("Perrito" + n);
        this.numHilo = n;
        this.dekker = dp;
        this.d=d;
    }
   
    @Override
    public void run(){
      
            while(true){
                try{
                        if(dekker.getTurno() != 0 ){
                           if(d.getTurno() != 0){    
                                Sc(this.getName());
                                d.setTurno(0);
                                dekker.setTurno(1);
                           }else{
                                Sc(this.getName());
                                d.setTurno(1);
                                dekker.setTurno(1);
                           }                   
                        }else{
                             if(d.getTurno() != 0){                                   
                                Sc(this.getName());
                                d.setTurno(0);
                                dekker.setTurno(0);                              
                             }else{
                                Sc(this.getName());
                                d.setTurno(1);   
                                 dekker.setTurno(0);                             
                             }                              
                        }
                         
                        if(isDead()){
                                area.append(rc.getRc() +" Me matan ... \n");
                                stop(); 
                        }  
                        inic = (int) ( Math.random()*10);
                        sleep((int) (inic +Math.random() * fin)); 
                }catch(Exception e){
                System.out.println(e.getMessage());
                } 
            }
          
    }
   private void Sc(String name){
              rc.setRc(name);
              area.append(rc.getRc() +": entra... \n"); 
    }
        public boolean isDead() {
                return dead;
        }

        public void setDead(boolean dead) {
                this.dead = dead;
        }

        public boolean isBlock() {
                return block;
        }

        public void setBlock(boolean block) {
                this.block = block;
        }
  
}
