package jp.isoittech.tools.alibikun;

import java.text.MessageFormat;

import it.sauronsoftware.cron4j.Scheduler;
import jp.isoittech.tools.alibikun.service.MouseMove;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlibiKunApplication {

    public static void main(String[] args) {

        String moveInterval = "1";
        if (args.length >= 1) {
            moveInterval = args[0];
        }

        log.info(MessageFormat.format("メイン処理開始: {0}分毎に動作します。",moveInterval));
        Scheduler scheduler = new Scheduler();
        scheduler.schedule(MessageFormat.format("*/{0} * * * *", moveInterval), new MouseMove());
        scheduler.start();
    }

}
