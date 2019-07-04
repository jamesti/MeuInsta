package senac.meuinsta.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

import senac.meuinsta.R;

public class PhotoAdapter extends RecyclerView.Adapter {

    private List<File> fotos;
    private Context context;

    public PhotoAdapter(List<File> fotos, Context context) {
        this.fotos = fotos;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.photo_item, parent, false);

        PhotoViewHolder holder = new PhotoViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PhotoViewHolder viewHolder = (PhotoViewHolder) holder;

        File photo = fotos.get(position);

        // Get the dimensions of the View
        int targetW = viewHolder.foto.getWidth();
        int targetH = viewHolder.foto.getHeight();

        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory. decodeFile(photo.getAbsolutePath(), bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeFile(photo.getAbsolutePath(), bmOptions);
        viewHolder.foto.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }
}
