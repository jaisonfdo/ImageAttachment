# ImageAttachment

Example App to show how to pick an image from Camera/Gallery 

<b>ImageUtils:</b> Used to capture/pick the image. from camera/gallery.

It contains the following methods.

<ul>

<li><b>imagepicker :</b> shows the picker with the options Camera and Gallery.</li>

<li><b>launchCamera :</b> Launch camera using native intent.</li>

<li><b>launchGallery :</b> Launch gallery using native intent.</li>

<li><b>checkimage :</b> Pass the filename and the file path ,then it will return the boolean value( Image exist or not).</li>

<li><b>getImage :</b> Pass the filename and the file path ,then it will return the bitmap if the image not exist then return null value.</li>

<li><b>createImage :</b> Pass the bitmap, filename, file path, and replace flag then it will store that image in the given path in the given name.</li>

</ul>

<b>ImageAttachmentListener:</b> This is a callback interface which returns the image capture/pick by you.

<pre>
public interface ImageAttachmentListener {
    public void image_attachment(int from, String filename, Bitmap file);
}</pre>


For implementing this image attachment process , first you need to create an instance for the class <b>ImageUtils</b>.  

<pre>
Imageutils imageutils;
imageutils =new Imageutils(this,this);
</pre>

Then call the relevant function based on your need.The following steps helps you to get the image.

<pre>

// Request code - 1
if (imageutils.isDeviceSupportCamera()) 
      imageutils.imagepicker(1);

</pre>



Next redirect your <b>onRequestPermissionsResult</b> to <b>imageutils.request_permission_result</b> and
<b>onActivityResult</b> to <b>imageutils.onActivityResult</b>.


For getting the callbacks you need to include <b>ImageAttachmentListener</b> interface into your activity,
and also implement the needed methods.

<pre>

public class ImageAttachmentActivity extends AppCompatActivity 
                               implements ImageAttachmentListener


// Callback function

@Override
public void image_attachment(int from, String filename, Bitmap file) {
    this.bitmap=file;
    this.file_name=filename;
    iv_attachment.setImageBitmap(file);

    String path =  Environment.getExternalStorageDirectory() + File.separator + "ImageAttach" + File.separator;
    
    //Store the selected image into your desired location

    imageutils.createImage(file,filename,path,false);

}

</pre>
In <b>AndroidManifest.xml</b>

Specify the needed permission. If you don't, permission requests fail silently. That's an Android thing.

<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>

For more information, check out my detailed guide here : http://droidmentor.com/pick-image-from-gallery-or-camera/

