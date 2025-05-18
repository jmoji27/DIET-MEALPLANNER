import React, { useState, useEffect } from "react";
// import axios from "axios";

const IngredientForm = () => {

// const IngredientForm = ({ editingPost, onPostUpdate }) => {
//   const [title, setTitle] = useState("");
//   const [content, setContent] = useState("");
//   const [image_url, setImage_url] = useState("");

//   useEffect(() => {
//     if (editingPost) {
//       setTitle(editingPost.title);
//       setContent(editingPost.content);
//       setImage_url(editingPost.image_url);
//     } else {
//       setTitle("");
//       setContent("");
//       setImage_url("");
//     }
//   }, [editingPost]);

//   const handleSubmit = async (event) => {
//     event.preventDefault();

//     const newPost = { title, content, image_url };

//     try {
//       if (editingPost) {
//         // Update Existing Post
//         await axios.put(`http://localhost:8080/api/admin/post/${editingPost.id}`, newPost);
//       } else {
//         // Create New Post
//         await axios.post("http://localhost:8080/api/admin/post", newPost);
//       }
//       onPostUpdate();
//     } catch (error) {
//       console.error("Error saving post:", error);
//     }
//   };

  return (
    <div className="p-4 bg-gray-100 rounded-lg mb-6">
        <h3>Admin Panel</h3>
      {/* <h3 className="text-xl font-semibold mb-4">{editingPost ? "Edit Post" : "Add New Post"}</h3> */}
      {/* <form onSubmit={handleSubmit}> */}
      <form >
        <input
          type="text"
          placeholder="Ingredient"
        //   value={title}
        //   onChange={(e) => setTitle(e.target.value)}
          className="w-full p-2 border rounded mb-2"
          required
        />
         <input
          type="text"
          placeholder="Calories"
        //   value={title}
        //   onChange={(e) => setTitle(e.target.value)}
          className="w-full p-2 border rounded mb-2"
          required
        />
        <input
          type="text"
          placeholder="Fat"
        //   value={content}
        //   onChange={(e) => setContent(e.target.value)}
          className="w-full p-2 border rounded mb-2"
          required
        />
        <input
          type="text"
          placeholder="Protein"
        //   value={image_url}
        //   onChange={(e) => setImage_url(e.target.value)}
          className="w-full p-2 border rounded mb-2"
        />
         <input
          type="text"
          placeholder="Carbs"
        //   value={title}
        //   onChange={(e) => setTitle(e.target.value)}
          className="w-full p-2 border rounded mb-2"
          required
        />
        <button
          type="submit"
          className="w-full bg-blue-500 text-black p-2 rounded"
        >
            Add Ingredient
          {/* {editingPost ? "Update Post" : "Add Post"} */}
        </button>
      </form>
    </div>
  );
};

export default IngredientForm;