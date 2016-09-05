package droidmentor.imageattachment;

import android.graphics.Bitmap;

/**
 * Created by Jaison on 31/08/16.
 */
public interface ImageAttachmentListener {
    public void image_attachment(int from, String filename, Bitmap file);
}
