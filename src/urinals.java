import java.util.ArrayList;
public class urinals {
    public static int getUrinals(String stalls) {
        int result;

        if( stalls.length()>0 && stalls.length()<=20) {
            if (stalls.contains("11")) {
                result = -1;
            } else if (onlyZeroes(stalls)) {
                result = (int) Math.ceil(stalls.length() / 2.0);
            } else {
                ArrayList<Integer> takenStalls = new ArrayList<Integer>();

                for (int i = 0; i < stalls.length(); i++) {
                    if (stalls.charAt(i) == '1') {
                        takenStalls.add(i);
                    }
                }

                int[] takenUrinals = new int[takenStalls.size()];

                for (int i = 0; i < takenStalls.size(); i++) {
                    takenUrinals[i] = takenStalls.get(i);
                }

                int[][] unusableUrinals = new int[takenUrinals.length][];

                int urinal;

                for (int i = 0; i < takenUrinals.length; i++) {
                    urinal = takenUrinals[i];
                    unusableUrinals[i] = getSurroundingUrinals(stalls, urinal);
                }

                int[][] unusableUrinalsRanges = new int[unusableUrinals.length][];
                int[] unusableUrinalsList;

                for (int i = 0; i < unusableUrinals.length; i++) {
                    unusableUrinalsList = unusableUrinals[i];
                    unusableUrinalsRanges[i] = getUrinalRange(unusableUrinalsList);
                }

                int[] unavailableUrinalsList = flatten(unusableUrinalsRanges);
                ArrayList<Integer> listOfUsableUrinals = new ArrayList<Integer>();

                for (int i = 0; i < stalls.length(); i++) {
                    if (!contains(unavailableUrinalsList, i) && stalls.charAt(i) != '1') {
                        listOfUsableUrinals.add(i);
                    }
                }

                int[] usableUrinalsList = new int[listOfUsableUrinals.size()];

                for (int i = 0; i < listOfUsableUrinals.size(); i++) {
                    usableUrinalsList[i] = listOfUsableUrinals.get(i);
                }

                int[][] usableUrinals = groupStalls(usableUrinalsList);
                result = 0;

                int maximumUsableUrinals;

                for (int[] usableUrinalList : usableUrinals) {
                    maximumUsableUrinals = (int) Math.ceil(usableUrinalList.length / 2.0);
                    result = result + maximumUsableUrinals;
                }
            }
            return result;
        }
        else return -1;
    }


    private static boolean onlyZeroes(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }



    private static int[] getUrinalRange(int[] list) {
        int[] result = new int[2];
        result[0] = list[0];
        result[1] = list[list.length - 1];
        return result;
    }


    private static int[] flatten(int[][] list) {
        ArrayList<Integer> elementList = new ArrayList<Integer>();
        for (int[] ints : list) {
            for (int element : ints) {
                elementList.add(element);
            }
        }
        int[] result = new int[elementList.size()];
        for (int i = 0; i < elementList.size(); i++) {
            result[i] = elementList.get(i);
        }
        return result;
    }

    private static int[] getSurroundingUrinals(String stalls, int urinal) {
        int[] result;
        if (urinal == 0) {
            result = new int[]{0, 1};
        }
        else if (urinal == stalls.length() - 1) {
            result = new int[]{stalls.length() - 2, stalls.length() - 1};
        }
        else {
            result = new int[]{urinal - 1, urinal, urinal + 1};
        }
        return result;
    }


    private static boolean contains(int[] list, int element) {
        for (int j : list) {
            if (j == element) {
                return true;
            }
        }
        return false;
    }


    private static int[][] groupStalls(int[] list) {
        ArrayList<int[]> groupStallList = new ArrayList<int[]>();
        if (list.length == 1) {
            int[] element = new int[]{list[0]};
            groupStallList.add(element);
        }
        else if (list.length == 2) {
            if (list[1] - list[0] == 1) {
                int[] element = new int[]{list[0], list[1]};
                groupStallList.add(element);
            }
            else {
                int[] element1 = new int[]{list[0]};
                groupStallList.add(element1);
                int[] element2 = new int[]{list[1]};
                groupStallList.add(element2);
            }
        }
        else if (list.length >= 3) {
            ArrayList<Integer> s = new ArrayList<Integer>();
            int[] sublist;
            while (list.length > 2) {
                if (list[1] - list[0] == 1) {
                    s.add(list[0]);
                    list = getSublist(list, list.length);
                }
                else {
                    s.add(list[0]);
                    list = getSublist(list, list.length);
                    sublist = new int[s.size()];
                    for (int i = 0; i < s.size(); i++) {
                        sublist[i] = s.get(i);
                    }
                    groupStallList.add(sublist);
                    s = new ArrayList<Integer>();
                }
            }
            if (list[1] - list[0] == 1) {
                s.add(list[0]);
                s.add(list[1]);
                sublist = new int[s.size()];
                for (int i = 0; i < s.size(); i++) {
                    sublist[i] = s.get(i);
                }
                groupStallList.add(sublist);
            }
            else {
                s.add(list[0]);
                sublist = new int[s.size()];
                for (int i = 0; i < s.size(); i++) {
                    sublist[i] = s.get(i);
                }
                groupStallList.add(sublist);
                int[] item = new int[]{list[1]};
                groupStallList.add(item);
            }
        }
        return groupStallList.toArray(new int[][]{});
    }


    private static int[] getSublist(int[] list, int end) {
        int[] result = new int[end - 1];
        System.arraycopy(list, 1, result, 0, end - 1);
        return result;
    }

}