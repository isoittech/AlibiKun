package jp.isoittech.tools.alibikun;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import it.sauronsoftware.cron4j.Scheduler;
import jp.isoittech.tools.alibikun.service.MouseMove;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlibiKunApplication {
    private static final String INIT_FILE_PATH = "AlibiKun.properties";
    private static final Properties properties;

    // コマンドプロンプトからプログラムを実行している場合、プログラムを実行しているディレクトリがカレントディレクトリ
    static {
        properties = new Properties();
        try {
            Path pgPath = getApplicationPath(AlibiKunApplication.class);
            String pgPathStr = pgPath.getParent().toString();
            System.out.println("プロパティファイル：" + pgPathStr + File.separator + INIT_FILE_PATH);
            properties.load(Files.newBufferedReader(Paths.get(pgPathStr + File.separator + INIT_FILE_PATH),
                    StandardCharsets.UTF_8));
            System.out.println(String.format("ファイルの読み込みに成功しました。ファイル名:%s", INIT_FILE_PATH));
        } catch (IOException e) {
            // ファイル読み込みに失敗
        } catch (URISyntaxException e) {
            // ファイル読み込みに失敗
        }
    }

    public static Path getApplicationPath(Class<?> cls) throws URISyntaxException {
        ProtectionDomain pd = cls.getProtectionDomain();
        CodeSource cs = pd.getCodeSource();
        URL location = cs.getLocation();
        URI uri = location.toURI();
        Path path = Paths.get(uri);
        return path;
    }

    public static void main(String[] args) {

        String moveInterval = "1";

        if (args.length >= 1) {
            moveInterval = args[0];
        } else if (!StringUtils.isEmpty(properties.getProperty("interval"))) {
            moveInterval = properties.getProperty("interval");
        }

        log.info(MessageFormat.format("メイン処理開始: {0}分毎に動作します。", moveInterval));
        Scheduler scheduler = new Scheduler();
        scheduler.schedule(MessageFormat.format("*/{0} * * * *", moveInterval), new MouseMove());
        scheduler.start();
    }

}
