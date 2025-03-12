import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.ls.LSException;

class Dataline{
    int version;
    String info;
    public Dataline(int version, String info) {
        this.version = version;
        this.info = info;
    }
    @Override
    public String toString() {
        return "version: "+this.version+"\tinfo: "+this.info;
    }
}

public class MVCC {
    static List<Dataline>m_ids=new LinkedList<>();//every class get the same date set!
    int min_trx_id;
    int max_trx_id;
    int creator_trx_id;
    
    public MVCC(int min_trx_id, int max_trx_id) {
        this.min_trx_id = min_trx_id;
        this.max_trx_id = max_trx_id;
        this.creator_trx_id = max_trx_id+1;
        m_ids.addFirst(creator_trx_id);
    }

    Dataline findTheCorrectData(){
        // 4 steps
        for (Dataline dataline : m_ids) {
            if(dataline.version==this.creator_trx_id){
                System.out.println("this date version equals to my own version, return the data, over!"+dataline.toString());
                return dataline;
            }else if (dataline.version<this.min_trx_id) {
                System.out.println("this date version less than min_trx_id, return the data, over!"+dataline.toString());
                return dataline;
            }else if(dataline.version>this.max_trx_id){
                System.out.println("this date version greater than max_trx_id, directly iterator the next version date, next...");
                return new Dataline(-1, "can't access the data after the trx created");
            }else{//[min_trx_id,max_trx_id]
                if (!m_ids.contains(dataline)) {
                    System.out.println("this date between [min_trx_id,max_trx_id],and not in active ,all ok ,return it"+dataline.toString());
                    return dataline;
                }else{
                   continue; 
                }
            }
        }
        return new Dataline(404, "NULL");
    }

   void setMinMax(){

   }
    public static void main(String[] args) {
        // initialization
        MVCC mvcc = new MVCC(0, 0);
        for (int i = 0; i < 10; i++) {
            // Create The Read_view

        }
    }
}
