package jp.isoittech.tools.alibikun;

import it.sauronsoftware.cron4j.Scheduler;
import jp.isoittech.tools.alibikun.service.MouseMove;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class AlibiKunApplication {

	public static void main(String[] args) {
		log.info("メイン処理開始");
        Scheduler scheduler = new Scheduler();
        scheduler.schedule("* * * * *", new MouseMove());
        scheduler.start();
	}

}
