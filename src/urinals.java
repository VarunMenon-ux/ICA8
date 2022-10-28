// AUTHOR: VARUN MENON
public class urinals {
    public static int getUrinals(String stalls) {

        if (stalls.length() > 0 && stalls.length() <= 20) {
            if (stalls.contains("11")) return -1;
            if (stalls.length() == 1) {
                if (stalls.contains("1"))
                    return 0;
                else return 1;
            }


            char[] arr = stalls.toCharArray();

            int counter = 0;
            if (arr[0] == '0' && arr[1] == '0') {
                arr[0] = '1';
                counter++;
            }

            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] == '0' && arr[i - 1] == '0' && arr[i + 1] == '0') {
                    counter++;
                    arr[i] = '1';
                }

            }

            int l = arr.length;
            if (arr[l - 2] == '0' && arr[l - 1] == '0') {
                counter++;
            }
            return counter;
        }

        else return -1;
    }
}
