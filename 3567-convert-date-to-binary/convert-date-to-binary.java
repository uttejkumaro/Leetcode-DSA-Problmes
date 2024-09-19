class Solution {
    public String convertDateToBinary(String date) {
        String[] dateParts = date.split("-");
        String year = dateParts[0];
        String month = dateParts[1];
        String day = dateParts[2];
        String yearBinary = Integer.toBinaryString(Integer.parseInt(year));
        String monthBinary = Integer.toBinaryString(Integer.parseInt(month));
        String dayBinary = Integer.toBinaryString(Integer.parseInt(day));
        return yearBinary + "-" + monthBinary + "-" + dayBinary;
    }
}
