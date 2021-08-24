package e.bolsadeideas.fanatic.learningfragments

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.parcelize.Parcelize

class MainViewModel: ViewModel() {
    private val userMutableLifeData = MutableLiveData<Usuario>()
    fun setUsuario(usuario: Usuario){
        userMutableLifeData.value = usuario
    }

    fun getUsuario(): LiveData<Usuario>{
        return userMutableLifeData
    }
}
@Parcelize
data class Usuario(val nombre: String, val edad: Int) : Parcelable