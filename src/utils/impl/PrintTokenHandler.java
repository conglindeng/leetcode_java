package utils.impl;

import utils.TokenHandler;

/**
 * @ClassName: PrintTokenHandler
 * @author: conglindeng
 * @email: conglin.deng@dmall.com
 * @Date 2022/10/18
 * @Description
 */
public class PrintTokenHandler implements TokenHandler {

    @Override
    public String handleToken(String content) {
        System.out.println(content);
        return content+"__s";
    }
}
