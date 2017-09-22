package phone.safe.lx.com.safephone;

import android.app.Service;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.IBinder;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;

import phone.safe.lx.com.safephone.comunication.ShareData;
import phone.safe.lx.com.safephone.gps.GpsHandler;
import phone.safe.lx.com.safephone.gps.LocationHandler;

public class ServiceDemo extends Service {

    private static final String TAG = "Service";
    private ImageView iv_image;
    private SurfaceTexture surfaceTexture;
//    private CameraViewService cameraViewService;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();

        int index = getFrontCameraId();
//        System.out.println(index + "          <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//        cameraViewService = new CameraViewService(getApplicationContext());
//        if (index == -1){
////            Toast.makeText(getApplicationContext(), "No front camera", Toast.LENGTH_LONG).show();
//        }
//        else
//        {
//            surfaceTexture = new SurfaceTexture(10);
//            sHolder = sv.getHolder();
//            sHolder.addCallback(this);
//            sHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
//        }
    }

    public void onStart(Intent intent, int startId) {
        Log.d(TAG, "onStart");
        ShareData.buildFirebaseDeviceData(getBaseContext());
        ShareData.retrieveData(getBaseContext());
    }

    public void onDestroy() {
        Log.d(TAG, "onDestroy");
    }


//    @Override
//    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h)
//    {
//        parameters = mCamera.getParameters();
//        mCamera.setParameters(parameters);
//        mCamera.startPreview();
//
//        Camera.PictureCallback mCall = new Camera.PictureCallback()
//        {
//            @Override
//            public void onPictureTaken(byte[] data, Camera camera)
//            {
//                Uri uriTarget = getContentResolver().insert//(Media.EXTERNAL_CONTENT_URI, image);
//                        (Media.EXTERNAL_CONTENT_URI, new ContentValues());
//
//                OutputStream imageFileOS;
//                try {
//                    imageFileOS = getContentResolver().openOutputStream(uriTarget);
//                    imageFileOS.write(data);
//                    imageFileOS.flush();
//                    imageFileOS.close();
//
//                    Toast.makeText(TakePictureActivity.this,
//                            "Image saved: " + uriTarget.toString(), Toast.LENGTH_LONG).show();
//                }
//                catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }catch (IOException e) {
//                    e.printStackTrace();
//                }
//                //mCamera.startPreview();
//
//                bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
//                iv_image.setImageBitmap(bmp);
//            }
//        };
//
//        mCamera.takePicture(null, null, mCall);
//    }

    int getFrontCameraId() {
        Camera.CameraInfo ci = new Camera.CameraInfo();
        for (int i = 0 ; i < Camera.getNumberOfCameras(); i++) {
            Camera.getCameraInfo(i, ci);
            if (ci.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) return i;
        }
        return -1; // No front-facing camera found
    }

//    @Override
//    public void surfaceCreated(SurfaceHolder holder)
//    {
//        int index = getFrontCameraId();
//        if (index == -1){
//            Toast.makeText(getApplicationContext(), "No front camera", Toast.LENGTH_LONG).show();
//        }
//        else
//        {
//            mCamera = Camera.open(index);
//            Toast.makeText(getApplicationContext(), "With front camera", Toast.LENGTH_LONG).show();
//        }
//        mCamera = Camera.open(index);
//        try {
//            mCamera.setPreviewDisplay(holder);
//
//        } catch (IOException exception) {
//            mCamera.release();
//            mCamera = null;
//        }
//
//    }

//    @Override
//    public void surfaceDestroyed(SurfaceHolder holder)
//    {
//        mCamera.stopPreview();
//        mCamera.release();
//        mCamera = null;
//    }

}