class solution1 {
    public static void main(String[] args) {

        // object to access input data
        Data data = new Data();

        // input arrays
        int c[][]=data.getParsedData();
        int a[]=c[0];
        int b[]=c[1];

        // sorting both input array in ascending order
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                int temp = 0;
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
                if (b[j] > b[j + 1]) {
                    temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                }
            }
        }

        // calculating total distance
        long distance = 0;
        for (int i = 0; i < a.length; i++) {
            distance += Math.abs(a[i] - b[i]);
        }
        System.out.println(distance);
    }
}