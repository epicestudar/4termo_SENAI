import Todo from "@/models/Todo";
import connectMongo from "@/utils/dbConnect";

export const getTodos = async () => {
    await connectMongo();
    return await Todo.find({});
}

export const createTodo = async (data) => {
    await connectMongo();
    return await Todo.create(data);
}