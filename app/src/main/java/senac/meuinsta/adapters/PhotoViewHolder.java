package senac.meuinsta.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import senac.meuinsta.R;

public class PhotoViewHolder extends RecyclerView.ViewHolder {

    final ImageView foto;

    public PhotoViewHolder(@NonNull View itemView) {
        super(itemView);
        foto = itemView.findViewById(R.id.imgItem);
    }

}
