class busyStudent {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int studentCount = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                studentCount++;
            }
        }
        return studentCount;
    }
}
