package cn.signature.tool.glide;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * @author pujiang
 * @date 2018-1-18 10:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class SignFileOutputStream extends FileOutputStream {
    byte[] BYTE_MAP;

    public SignFileOutputStream(String name) throws IOException {
        this(new File(name));
    }

    public SignFileOutputStream(File file) throws IOException {
        super(file);
        BYTE_MAP = new byte[256];
        for (int i = 0; i < 256; i++) {
            BYTE_MAP[i] = (byte) i;
        }
        Random random = new Random();
        for (int i = 0; i < BYTE_MAP.length; i++) {
            int p = random.nextInt(256);
            byte b = BYTE_MAP[i];
            BYTE_MAP[i] = BYTE_MAP[p];
            BYTE_MAP[p] = b;
        }
        //write magic num
        super.write(new byte[]{0x1A, 0x2A}, 0, 2);
        super.write(BYTE_MAP, 0, 256);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            b[i] = BYTE_MAP[b[i] & 0xFF];
        }
        super.write(b, off, len);
    }
}
