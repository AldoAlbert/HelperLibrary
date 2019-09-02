package cs.com.toolslibrary

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar

import com.google.android.material.snackbar.Snackbar

class SnackBarBuilder {

    private var c: Context? = null
    private var parent: View? = null

    constructor(c: Context, parent: View){
        this.c = c
        this.parent = parent
    }

    private fun makeSnackBar(message: String) {
        parent?.let { Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show() }
    }

    fun buildSnackBar(message: String) {
        makeSnackBar(message)
    }

    fun buildErrorSnackBar() {
        c?.getString(R.string.error_generico)?.let { makeSnackBar(it) }
    }

    fun buildNetworkErrorSnackBar() {
        c?.getString(R.string.error_intenet)?.let { makeSnackBar(it) }
    }

    fun buildCardErrorSnackBar() {
        c?.getString(R.string.error_procesar_tarjeta)?.let { makeSnackBar(it) }
    }

    fun buildInvalidFilesSnackBar() {
        c?.getString(R.string.error_archivos_vacios)?.let { makeSnackBar(it) }
    }

    fun buildUnavalibleFilesSnackBar() {
        c?.getString(R.string.error_archivos_faltantes)?.let { makeSnackBar(it) }
    }

    fun buildLoadingSnackBar() {
        val bar = parent?.let { c?.getString(R.string.cargando)?.let { it1 -> Snackbar.make(it, it1, Snackbar.LENGTH_INDEFINITE) } }
        val contentLay = bar?.view?.findViewById<View>(com.google.android.material.R.id.snackbar_text)?.parent as ViewGroup
        val item = ProgressBar(c)
        contentLay.addView(item, 0)
        bar?.show()
    }

}
