package jp.isoittech.tools.alibikun.service;

import org.sikuli.script.Location;
import org.sikuli.script.Screen;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MouseMove implements Runnable {
	@Override
	public void run() {

		try {
			log.info("処理開始");
			Screen s = new Screen();

			Location topLeft = s.getTopLeft();
			s.mouseMove(topLeft);

			s.mouseMove(150, 50);
			s.mouseMove(40, 90);
			s.mouseMove(60, 65);

			log.info("正常終了");
		} catch (Throwable e) {
			log.error("定期マウスカーソル移動処理で{}が発生しました。", e);
			e.printStackTrace();
		}
	}
}