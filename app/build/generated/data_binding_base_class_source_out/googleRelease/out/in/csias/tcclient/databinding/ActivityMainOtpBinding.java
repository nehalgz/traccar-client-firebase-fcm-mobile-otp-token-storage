// Generated by view binder compiler. Do not edit!
package in.csias.tcclient.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hbb20.CountryCodePicker;
import in.csias.tcclient.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainOtpBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final CountryCodePicker ccp;

  @NonNull
  public final Button nextBtn;

  @NonNull
  public final EditText phoneNumberEt;

  @NonNull
  public final TextView textMsisdnRequest;

  private ActivityMainOtpBinding(@NonNull ScrollView rootView, @NonNull CountryCodePicker ccp,
      @NonNull Button nextBtn, @NonNull EditText phoneNumberEt,
      @NonNull TextView textMsisdnRequest) {
    this.rootView = rootView;
    this.ccp = ccp;
    this.nextBtn = nextBtn;
    this.phoneNumberEt = phoneNumberEt;
    this.textMsisdnRequest = textMsisdnRequest;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainOtpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainOtpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main_otp, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainOtpBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ccp;
      CountryCodePicker ccp = ViewBindings.findChildViewById(rootView, id);
      if (ccp == null) {
        break missingId;
      }

      id = R.id.next_btn;
      Button nextBtn = ViewBindings.findChildViewById(rootView, id);
      if (nextBtn == null) {
        break missingId;
      }

      id = R.id.phoneNumberEt;
      EditText phoneNumberEt = ViewBindings.findChildViewById(rootView, id);
      if (phoneNumberEt == null) {
        break missingId;
      }

      id = R.id.text_msisdn_request;
      TextView textMsisdnRequest = ViewBindings.findChildViewById(rootView, id);
      if (textMsisdnRequest == null) {
        break missingId;
      }

      return new ActivityMainOtpBinding((ScrollView) rootView, ccp, nextBtn, phoneNumberEt,
          textMsisdnRequest);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
