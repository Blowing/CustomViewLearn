package com.wujie.customviewlearn.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.wujie.customviewlearn.R;

public class PrimaryColorActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private static final int MAX_VALUE = 255;
    private static final int MID_VALUE = 127;

    private ImageView mImageView;
    private float mHue, mSatureation , mLum;
    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_color);

        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.we);

        mImageView = findViewById(R.id.primary_iv);

        SeekBar seekBarHue = findViewById(R.id.rotate_seek_bar);
        SeekBar seekBarSaturation = findViewById(R.id.saturation_seek_bar);
        SeekBar seekBarLum = findViewById(R.id.lum_seek_bar);

        seekBarHue.setOnSeekBarChangeListener(this);
        seekBarSaturation.setOnSeekBarChangeListener(this);
        seekBarLum.setOnSeekBarChangeListener(this);

        seekBarHue.setMax(MAX_VALUE);
        seekBarLum.setMax(MAX_VALUE);
        seekBarSaturation.setMax(MAX_VALUE);

        seekBarHue.setProgress(MID_VALUE);
        seekBarLum.setProgress(MID_VALUE);
        seekBarSaturation.setProgress(MID_VALUE);

        mImageView.setImageBitmap(mBitmap);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.rotate_seek_bar:
                mHue = (progress - MID_VALUE) * 1.0f / MID_VALUE*180;
                break;
            case R.id.saturation_seek_bar:
                mSatureation = progress * 1.0f/ MID_VALUE;
                break;
            case R.id.lum_seek_bar:
                mLum = progress *1.0f /MID_VALUE;
                break;
        }
        mImageView.setImageBitmap(handleImageEffect(mBitmap, mHue, mSatureation, mLum));
     }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private Bitmap handleImageEffect(Bitmap bm, float hue, float saturation, float lum) {
        ColorMatrix hueMatrix = new ColorMatrix();
        hueMatrix.setRotate(0, hue);
        hueMatrix.setRotate(1, hue);
        hueMatrix.setRotate(2, hue);

        ColorMatrix sturationMatrix = new ColorMatrix();
        sturationMatrix.setSaturation(saturation);

        ColorMatrix lumMatrix = new ColorMatrix();
        lumMatrix.setScale(lum, lum, lum , 1);

        ColorMatrix imageMatrix = new ColorMatrix();
        imageMatrix.postConcat(hueMatrix);
        imageMatrix.postConcat(sturationMatrix);
        imageMatrix.postConcat(lumMatrix);

        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));

        Bitmap bitmap = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(bm, 0 , 0, paint);
        return bitmap;

    }
}
