<?php


namespace App\Http\Controllers;


use Illuminate\Http\Request;
use App\Models\Usuario;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;




class UsuarioController extends Controller
{
    // Exibir o formulário de login
    public function showLoginForm()
    {
        return view('usuarios.login');
    }




    // Processar o login do usuário
    public function login(Request $request)
    {
        $request->validate([
            'email' => 'required|string|email',
            'password' => 'required|string',
        ]);


        $usuario = Usuario::where('email', $request->email)->first();
        if($usuario && Hash::check($request->password, $usuario->password)) {
            session(['usuario_id' => $usuario->id]);
            return redirect()->route('dashboard');
        } else{
            return back()->withErrors([
                'email' => 'As credenciais não correspondem aos nossos registros.',
            ]);
        }
    }


    // Exibir o formulário de registro
    public function showRegisterForm()
    {
        return view('usuarios.registro');
    }


    // Processar o registro de um novo usuário
    public function registro(Request $request)
    {
        $request->validate([
            'nome' => 'required|string',
            'email' => 'required|string|email|unique:usuarios',
            'password' => 'required|string|min:4|confirmed',
        ]);


        $usuario = Usuario::create([
            'nome' => $request->nome,
            'email' => $request->email,
            'password' => Hash::make($request->password),
        ]);


        Auth::login($usuario);


        return redirect('/dashboard');
    }


    // Realizar o logout do usuário
    public function logout(Request $request)
    {
        Auth::logout();


        $request->session()->invalidate();
        $request->session()->regenerateToken();


        return redirect('/');
    }
}
