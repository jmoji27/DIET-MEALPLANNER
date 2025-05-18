import React, { useEffect, useState } from "react";
import axios from "axios";
import PostForm from "./IngredientForm.jsx";
import { useNavigate } from "react-router-dom";

const AdminPanel = () => {
  const [posts, setPosts] = useState([]);
  const [editingPost, setEditingPost] = useState(null);

  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("token"); // ✅ Remove token
    navigate("/login"); // ✅ Redirect to login page
  };
    useEffect(() => {
      fetchPosts();
    }, []);



 

  const fetchPosts = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/admin/ingredient");
      setPosts(response.data);
    } catch (error) {
      console.error("Error fetching posts:", error);
    }
  };


  const deletePost = async (id) => {
    if (window.confirm("Are you sure you want to delete this post?")) {
      try {
        await axios.delete(`http://localhost:8080/api/admin/ingredient/${id}`);
        fetchPosts();
      } catch (error) {
        console.error("Error deleting post:", error);
      }
    }
  };

  const handleEdit = (posts) => {
    setEditingPost(posts);
  };

  const handlePostUpdate = () => {
    setEditingPost(null);
    fetchPosts();
  };

  return (
    <div className="max-w-6xl mx-auto mt-6 p-4 bg-white shadow-lg rounded-lg">
      <h2 className="text-3xl font-bold text-center mb-6">Admin Dashboard</h2>

      {/* Post Form for Adding & Editing */}
      <PostForm editingPost={editingPost} onPostUpdate={handlePostUpdate} />

      {/* Post Management Table */}
      <table className="w-full border-collapse border border-gray-300 mt-6">
        <thead>
          <tr className="bg-gray-200">
            <th className="border p-3">ID</th>
            <th className="border p-3">Title</th>
            <th className="border p-3">Content</th>
            <th className="border p-3">Image</th>
            <th className="border p-3">Actions</th>
          </tr>
        </thead>
        <tbody>
          {posts.map((posts) => (
            <tr key={posts.id} className="text-center">
              <td className="border p-3">{posts.id}</td>
              <td className="border p-3">{posts.title}</td>
              <td className="border p-3 truncate max-w-xs">{posts.content}</td>
              <td className="border p-3">
                {posts.image_url ? (
                  <img src={posts.image_url} alt={posts.title} className="w-20 h-20 object-cover mx-auto" />
                ) : (
                  "No Image"
                )}
              </td>
              <td className="border p-3">
                <button
                  onClick={() => handleEdit(posts)}
                  className="bg-yellow-500 text-black px-3 py-1 rounded mr-2"
                >
                  Edit
                </button>
                <button
                  onClick={() => deletePost(posts.id)}
                  className="bg-red-500 text-black px-3 py-1 rounded"
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <button
                   onClick={() => handleLogout()}
                  className="bg-red-500 text-black px-3 py-1 rounded "
                >
                  Log Out
                </button>
    </div>
  );
};

export default AdminPanel;
