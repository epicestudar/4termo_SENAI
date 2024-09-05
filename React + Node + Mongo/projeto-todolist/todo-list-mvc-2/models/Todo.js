import mongoose from "mongoose";

const TodoSchema = new mongoose.Schema({
    title: {
        type: String,
        required:true
    },
    description: {
        type: String,
        required: false
    },
    status: {
        type: String,
        enum: ["A fazer", "Fazendo", "Feito"],
        default: "A fazer"
    }
})

const Todo = mongoose.models.Todo || mongoose.model("Todo", TodoSchema);

export default Todo;