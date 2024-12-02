public class solution2 {
    public static void main(String[] args) {
        Data data=new Data();
        int c[][]=data.getParsedData();

        int a[]=c[0];
        int b[]=c[1];
        

        int counter=0;
        int result[]=new int[a.length];
        for(int i=0; i<a.length; i++)
        {

            for(int j=0; j<b.length;j++)
            {
                if(a[i]==b[j]){
                    counter++;
                }
            }
            result[i]=counter;
            counter=0;
        }

        int similarity_score=0;
        for(int i=0;i<result.length;i++)
        {
            similarity_score+=a[i]*result[i];
        }
        System.out.print(similarity_score);
    }
}
