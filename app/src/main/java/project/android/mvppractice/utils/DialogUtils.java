package project.android.mvppractice.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import project.android.mvppractice.R;


public class DialogUtils {




        private static final String TAG = "CommonUtils";

    private DialogUtils() {
            // This utility class is not publicly instantiable
        }

        public static ProgressDialog showLoadingDialog(Context context) {
            ProgressDialog progressDialog    = new ProgressDialog(context);
            progressDialog.show();
            if (progressDialog.getWindow() != null) {
                progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
            progressDialog.setContentView(R.layout.progress_dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
            return progressDialog;
        }


}
