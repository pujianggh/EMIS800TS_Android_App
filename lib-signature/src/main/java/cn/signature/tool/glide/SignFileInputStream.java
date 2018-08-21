package cn.signature.tool.glide;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author pujiang
 * @date 2018-1-18 10:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class SignFileInputStream extends FileInputStream {
    byte[] BYTE_MAP = new byte[256];

    public SignFileInputStream(String name) throws IOException {
        this(new File(name));
    }

    public SignFileInputStream(File file) throws IOException {
        super(file);
        if (file.length() <= 256) throw new IOException("Not a .sign File");
        byte[] magicNum = new byte[2];
        super.read(magicNum, 0, 2);
        if (magicNum[0] == 0x1A && magicNum[1] == 0x2A) {
            byte[] temp = new byte[256];
            super.read(temp, 0, 256);
            for (int i = 0; i < temp.length; i++) {
                BYTE_MAP[temp[i] & 0xFF] = (byte) i;
            }
        } else {
            throw new IOException("Not a .sign File,Magic num not 0x1A,0x2A");
        }

    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int t = super.read(b, off, len);
        for (int i = off; i < off + t; i++) {
            b[i] = BYTE_MAP[b[i] & 0xFF];
        }
        return t;
    }
}
