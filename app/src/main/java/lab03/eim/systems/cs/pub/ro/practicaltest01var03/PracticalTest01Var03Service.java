package lab03.eim.systems.cs.pub.ro.practicaltest01var03;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

public class PracticalTest01Var03Service extends Service {

    public static final String ACTION_SUM = "com.example.practicaltest01var03.action.SUM";
    public static final String ACTION_DIFF = "com.example.practicaltest01var03.action.DIFF";
    public static final String BROADCAST_MESSAGE = "broadcast_message";

    private final Handler handler = new Handler();
    private int firstNumber;
    private int secondNumber;

    private final Runnable sendBroadcasts = new Runnable() {
        private int broadcastCount = 0;

        @Override
        public void run() {
            if (broadcastCount < 2) {
                Intent broadcastIntent = new Intent();

                if (broadcastCount % 2 == 0) {
                    broadcastIntent.setAction(ACTION_SUM);
                    broadcastIntent.putExtra(BROADCAST_MESSAGE, "Suma: " + (firstNumber + secondNumber));
                } else {
                    broadcastIntent.setAction(ACTION_DIFF);
                    broadcastIntent.putExtra(BROADCAST_MESSAGE, "Diferenta: " + (firstNumber - secondNumber));
                }

                sendBroadcast(broadcastIntent);
                broadcastCount++;
                handler.postDelayed(this, 5000);
            } else {
                stopSelf();
            }
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        firstNumber = intent.getIntExtra("firstNumber", 0);
        secondNumber = intent.getIntExtra("secondNumber", 0);
        handler.post(sendBroadcasts);
        return START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Return null because it's a started service, not a bound service.
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(sendBroadcasts);
    }
}
