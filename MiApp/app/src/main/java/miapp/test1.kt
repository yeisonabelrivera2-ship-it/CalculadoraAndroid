package miapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.KeyboardOptions

@Composable
fun MyTextField(modifier: Modifier = Modifier){
    var user by rememberSaveable { mutableStateOf("") }
    var dato by rememberSaveable { mutableStateOf("") }
    var dato2 by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Usuario", modifier = Modifier.padding(end = 5.dp))
            MyTextFieldUser(user) { user = it }
        }
        Text(user)
        TextFieldDato(dato) { dato = it }
        PasswordTextField(password) { password = it }
        TextFieldChange(dato2) { dato2 = it }

    }
}

@Composable
fun MyTextFieldUser(user: String, onUserChange: (String) -> Unit){
    TextField(value = user, onValueChange = { onUserChange(it) })
}

@Composable
fun TextFieldDato(dato: String, onValueChange: (String) -> Unit){
    TextField(value = dato, onValueChange = { onValueChange(it) },
        placeholder = { MyBoxWithText() }
    )
}

@Composable
fun MyBoxWithText(){
    Box(modifier = Modifier.size(100.dp).background(Color.Red)){
        Text("Introducir dato")
    }
}

@Composable
fun PasswordTextField(
    password: String,
    onValueChange: (String) -> Unit
){
    var visible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = { Text("Password") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if(visible){
            VisualTransformation.None
        }else{
            PasswordVisualTransformation()
        },
        trailingIcon = {
            val image = if(visible){
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            val descripcion = if (visible) "Ocultar" else "Mostrar"

            IconButton(onClick = { visible = !visible }){
                Icon(imageVector = image, contentDescription = descripcion)
            }
        }
    )
}

@Composable
fun TextFieldChange(

    dato: String,
    onValueChange: (String) -> Unit
){
    TextField(value = dato,onValueChange={
        if(it.contains("a")){
            onValueChange(it.replace("a","B"))
        }else{
            onValueChange(it)
        }
    })
}
