package cs.com.toolslibrary;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditTextValidator {

    private static final String EMAIL_PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private static final String LETTERS_SPACE = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$";
    private static final String ONLY_NUMBERS = "^[0-9]+$";

    private boolean result;
    private View v;

    private Context c;

    public EditTextValidator(Context c){
        this.result = true;
        this.v = null;
        this.c = c;
    }

    public void setView(View v) {
        this.v = v;
    }

    public void showErrors(){
        v.requestFocus();
    }

    public boolean isResult() {
        return result;
    }

    public View getView() {
        return v;
    }

    public boolean validate(){
        if(!result){
            v.requestFocus();
        }
        return result;
    }

    private void setResult(boolean result) {
        this.result = result;
    }

    private void setView(EditText e){
        v = e;
    }

    private void setError(EditText editText, String error){
        editText.setError(error);
        setResult(false);
        setView(editText);
    }

    public void requiredField(EditText editText){
        editText.setError(null);
        if(editText.getText().toString().isEmpty()){
            setError(editText, c.getString(R.string.error_campo_requerido));
        }
    }

    public void validateOnlyLetters(EditText editText){
        editText.setError(null);
        if (!onlyLetters(editText.getText().toString())){
            setError(editText, c.getString(R.string.error_solo_letras));
        }
    }

    public void validateOnlyNumbers(EditText editText){
        editText.setError(null);
        if (!onlyNumbers(editText.getText().toString())){
            setError(editText, c.getString(R.string.error_solo_numeros));
        }
    }

    public void validateLength(EditText editText, int minLength){
        editText.setError(null);
        if(editText.getText().toString().trim().length() < minLength){
            setError(editText, c.getString(R.string.error_caracteres_minimos, minLength));
        }
    }

    public void validateEmail(EditText ET_email){
        if(!EditTextValidator.validateEmail(ET_email.getText().toString())){
            setError(ET_email, c.getString(R.string.error_email_invalido));
        }
    }

    public void validatePasswords(EditText ET_contrasena, EditText ET_confirmar_contrasena, int min_long){
        ET_contrasena.setError(null);
        ET_confirmar_contrasena.setError(null);
        if(ET_contrasena.length() < min_long){
            setError(ET_contrasena, c.getString(R.string.error_longitud_contrasena, min_long));
        } else if(! ( ET_contrasena.getText().toString().equals( ET_confirmar_contrasena.getText().toString() ) ) ){
            setError(ET_confirmar_contrasena, c.getString(R.string.error_las_contraseñas_no_coinciden));
        }

    }

    public void validateTelephone(EditText editText, int longitude){
        editText.setError(null);
        if ( editText.getText().toString().length() < longitude || editText.getText().toString().length() > longitude ){
            setError(editText, c.getString(R.string.error_longitud_telefono));
        } else if (!onlyNumbers(editText.getText().toString())){
            setError(editText, c.getString(R.string.error_solo_numeros));
        }

    }

    private boolean onlyNumbers(String string){
        Pattern pattern = Pattern.compile(ONLY_NUMBERS);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    private boolean onlyLetters(String string){
        Pattern pattern = Pattern.compile(LETTERS_SPACE);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    private static boolean validateEmail(String email){
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
