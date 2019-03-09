public class Matrix{
   
    int[][] matrix;
    int x_size;
    int y_size;

    Matrix(int[][] A){
        this.matrix = A;
        this.x_size = A.length;
        this.y_size = A[0].length;
    }

    public void show(){
        
        for(int i=0; i<this.matrix.length; i++){
            for(int j=0; j<this.matrix[0].length; j++){
                
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    // rotateMatrix
    public boolean rotate(){
        
        // dimA = 0 or NxM matrix means failure
        if(this.x_size == 0 || this.x_size != this.y_size) return false;

        return rotate_inner(this.matrix);
    }
    
    /*
    start-last
    < - - - >
    1 1 1 1 1 *         * * * * * 1 
    * 2 2 2 * *         * * * * 2 1
    * * 3 * * *  --->   * * * 3 2 1
    * * * * * *         * * * * 2 1
    * * * * * *         * * * * * 1
    * * * * * *         * * * * * *
    */

    private boolean rotate_inner(int[][] A){
        
        int n = A.length;

        int start, last;
        for(int layer=0; layer<n/2; layer++){
            
            start = layer;
            last = n - layer - 1;

            for(int i=start; i<last; i++){
                
                int offset = i - start;
                int top = A[start][i];

                // top <- left
                A[start][i] = A[last-offset][start];

                // left <- bottom
                A[last-offset][start] = A[last][last-offset];

                // bottom <- right
                A[last][last-offset] = A[i][last];

                // right <- top
                A[i][last] = top;
            }
        }

        // success
        return true;
    }

    // setZeros
    private void zerosRow(int n){
        
        for(int i=0; i<this.x_size; i++){
            this.matrix[n][i] = 0;
        }          
    }
    
    private void zerosColumn(int n){
        
        for(int i=0; i<this.y_size; i++){
            this.matrix[i][n] = 0;
        }          
    }
    
    public void setZeros(){
        
        boolean[] row = new boolean[this.x_size];
        boolean[] column = new boolean[this.y_size];

        // search zeros
        for(int i=0; i<this.y_size; i++){
            for(int j=0; j<this.x_size; j++){
                if(this.matrix[i][j] == 0){
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for(int i=0; i<row.length; i++){
            if(row[i]) zerosRow(i);
        }
        
        for(int i=0; i<column.length; i++){
            if(column[i]) zerosColumn(i);
        }
    }

}
