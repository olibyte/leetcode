class diagonalSum {
    public int diagonalSum(int[][] mat) {
        
        int sum = 0;
        
        for(int i = 0; i < mat.length / 2; i++) {
            //from the top
                sum += mat[i][i] + mat[i][mat.length-1-i];
                //from the bottom
                sum += mat[mat.length-1-i][i] + mat[mat.length-1-i][mat.length-1-i];
        }
        if (mat.length % 2 != 0)
            sum += mat[mat.length/2][mat.length/2];
        
        return sum;
    }
}
