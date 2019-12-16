package TeestTh;

import java.io.*;

public class MyObjectOutStream extends ObjectOutputStream {
    public static File fg;

    private MyObjectOutStream(OutputStream outputStream,File f) throws IOException {
        super(outputStream);
    }
    public  static  MyObjectOutStream newInstance(OutputStream outputStream,File f) throws IOException {
        fg=f;
        return new MyObjectOutStream(outputStream,f);
    }
    @Override
    protected void writeStreamHeader() throws IOException {
        if(fg.length()==0){
            super.writeStreamHeader();
        }
        else {
            super.reset();
        }
    }
}
