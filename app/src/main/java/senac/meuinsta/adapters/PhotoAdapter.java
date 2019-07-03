package senac.meuinsta.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import senac.meuinsta.R;

public class PhotoAdapter extends RecyclerView.Adapter {

    private List<Bitmap> fotos;
    private Context context;

    public PhotoAdapter(List<Bitmap> fotos, Context context) {
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

        Bitmap photo = fotos.get(position);

        viewHolder.foto.setImageBitmap(photo);
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }
}
