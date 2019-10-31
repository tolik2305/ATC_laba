package tocman.classes;

import tocman.ClassMain;

import java.util.TimerTask;

public class LoopTask extends TimerTask {
        public void run() {
            ClassMain.BackUp();
        }
}
