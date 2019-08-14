package com.demo.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.sql.Timestamp;

/**
 * 自定义字符输出流
 * 应用装饰模式
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月14日 11:26:21
 */
public class CommentWriter extends Writer {

    private Writer out;

    public CommentWriter() {
    }

    public  CommentWriter(Writer out) {
        this.out = out;
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        out.write("#"+new Timestamp(System.currentTimeMillis()));
        out.write("\r\n");
        out.write(cbuf, off, len);
    }

    @Override
    public void write(String str) throws IOException {
        this.write(str.toCharArray(), 0, str.toCharArray().length);
    }

    @Override
    public void flush() throws IOException {
        out.flush();
    }

    @Override
    public void close() throws IOException {
        out.close();
    }
}
