package google.thirdpartylibraries;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.BindView;

public class PicassoPaletteActivity extends AppCompatActivity {

    @BindView(R.id.viewVibrantColor)
    View vibrantColorView;

    @BindView(R.id.viewDarkVibrantColor)
    View darkVibrantColorView;

    @BindView(R.id.viewLightVibrantColor)
    View lightVibrantColorView;

    @BindView(R.id.viewMutedColor)
    View mutedColorView;

    @BindView(R.id.viewDarkMutedColor)
    View darkMutedColorView;

    @BindView(R.id.viewLightMutedColor)
    View lightMutedColorView;

    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso_palette);

        ButterKnife.bind(this);

        Picasso.with(this)
                .load("http://www.androidguys.com/wp-content/uploads/2014/11/14-2-e1415917898390.png")
                .fit()
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {

                        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();

                        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(Palette palette) {
                                displayPalettes(palette);
                            }
                        });
                    }

                    @Override
                    public void onError() {

                    }
                });
    }

    private void displayPalettes(Palette palette) {
        if (palette.getVibrantSwatch() != null) {
            vibrantColorView.setBackgroundColor(palette.getVibrantSwatch().getRgb());
        }

        if (palette.getDarkVibrantSwatch() != null) {
            darkVibrantColorView.setBackgroundColor(palette.getDarkVibrantSwatch().getRgb());
        }

        if (palette.getLightVibrantSwatch() != null) {
            lightVibrantColorView.setBackgroundColor(palette.getLightVibrantSwatch().getRgb());
        }

        if (palette.getMutedSwatch() != null) {
            mutedColorView.setBackgroundColor(palette.getMutedSwatch().getRgb());
        }

        if (palette.getDarkMutedSwatch() != null) {
            darkMutedColorView.setBackgroundColor(palette.getDarkMutedSwatch().getRgb());
        }

        if (palette.getLightMutedSwatch() != null) {
            lightMutedColorView.setBackgroundColor(palette.getLightMutedSwatch().getRgb());
        }
    }
}
