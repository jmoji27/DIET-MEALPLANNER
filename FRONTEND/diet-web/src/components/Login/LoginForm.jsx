// import React, { useState } from 'react';

// function LoginForm() {
//   const [email, setEmail] = useState('');
//   const [password, setPassword] = useState('');

//   const handleSubmit = (e) => {
//     e.preventDefault();

//     if (!email || !password) {
//       alert('Please fill in both fields');
//       return;
//     }

//     console.log('Logging in with:', { email, password });
//   };

//   // 🔵 Inline styles
//   const styles = {
//     container: {
//       maxWidth: '350px',
//       margin: '80px auto',
//       padding: '30px',
//       backgroundColor: '#f9f9f9',
//       borderRadius: '8px',
//       boxShadow: '0 4px 12px rgba(0, 0, 0, 0.1)',
//     },
//     heading: {
//       textAlign: 'center',
//       marginBottom: '20px',
//     },
//     input: {
//       width: '100%',
//       padding: '12px',
//       margin: '10px 0',
//       border: '1px solid #ccc',
//       borderRadius: '4px',
//       boxSizing: 'border-box',
//     },
//     button: {
//       width: '100%',
//       padding: '12px',
//       backgroundColor: '#007bff',
//       color: 'white',
//       border: 'none',
//       borderRadius: '4px',
//       cursor: 'pointer',
//     },
//     buttonHover: {
//       backgroundColor: '#0056b3',
//     },
//   };

//   return (
//     <div style={styles.container}>
//       <h2 style={styles.heading}>Login</h2>
//       <form onSubmit={handleSubmit}>
//         <input
//           type="email"
//           placeholder="Email"
//           value={email}
//           onChange={(e) => setEmail(e.target.value)}
//           style={styles.input}
//         />
//         <input
//           type="password"
//           placeholder="Password"
//           value={password}
//           onChange={(e) => setPassword(e.target.value)}
//           style={styles.input}
//         />
//          {/* <Link to={<RegistrationForm/>}>
//          <div>
//          <h3>Sign up for new account</h3>
//          </div>
    
//         </Link> */}
//         <a href="/RegistrationForm">sign up</a>
//         <button
//           type="submit"
//           style={styles.button}
//           onMouseOver={(e) => (e.target.style.backgroundColor = styles.buttonHover.backgroundColor)}
//           onMouseOut={(e) => (e.target.style.backgroundColor = styles.button.backgroundColor)}
//         >
//           Login
//         </button>
//       </form>
//     </div>
//   );
// }

// export default LoginForm;



import React, { useState } from "react";

const LoginForm = () => {
  const [isLogin, setIsLogin] = useState(true); // Toggle between login/register
  const [form, setForm] = useState({
    name: "",
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    setForm((prev) => ({
      ...prev,
      [e.target.name]: e.target.value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (isLogin) {
      // ✅ Handle Login
      console.log("Login:", form.email, form.password);
    } else {
      // ✅ Handle Registration
      console.log("Register:", form.name, form.email, form.password);
    }
  };

  return (
    <div className="max-w-sm mx-auto mt-10 p-6 bg-white shadow rounded">
      <h2 className="text-xl font-bold mb-4 text-center">
        {isLogin ? "Login" : "Register"}
      </h2>
      <form onSubmit={handleSubmit} className="space-y-4">
        {!isLogin && (
          <input
            type="text"
            name="name"
            placeholder="Full Name"
            value={form.name}
            onChange={handleChange}
            required
            className="w-full p-2 border rounded"
          />
        )}

        <input
          type="email"
          name="email"
          placeholder="Gmail"
          value={form.email}
          onChange={handleChange}
          required
          className="w-full p-2 border rounded"
        />

        <input
          type="password"
          name="password"
          placeholder="Password"
          value={form.password}
          onChange={handleChange}
          required
          className="w-full p-2 border rounded"
        />

        <button
          type="submit"
          className="w-full bg-blue-600 hover:bg-blue-700 text-white py-2 rounded"
        >
          {isLogin ? "Log In" : "Sign Up"}
        </button>
      </form>

      <p className="text-sm text-center mt-4">
        {isLogin ? "Don't have an account?" : "Already have an account?"}{" "}
        <button
          type="button"
          onClick={() => setIsLogin(!isLogin)}
          className="text-blue-500 underline"
        >
          {isLogin ? "Register" : "Login"}
        </button>
      </p>
    </div>
  );
};

export default LoginForm;

