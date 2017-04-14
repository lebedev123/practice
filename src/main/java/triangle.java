/**
 * Created by dos on 07.08.2016.
 */
public class triangle {
    double area;
    int height;
    int lenght;
    public static void main(String[] args){
        triangle[] ta = new triangle[4];
        int x = 0;
        while(x<4){
            ta[x] = new triangle();
            ta[x].height = (x+1)*2;
            ta[x].lenght = x+4;
            ta[x].setArea();
            System.out.print("treygolnik "+x+", zona");
            System.out.println("="+ ta[x].area);
            x++;
        }
        int y =x;
        x=27;
        triangle t5 = ta[2];
        ta[2].area = 343;
        System.out.print("y ="+y);
        System.out.println(",zona t5 = "+t5.area);
    }
    void setArea(){
        area = (lenght*height)/2;
    }

}
