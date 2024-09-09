import Todo from "@/models/Todo";
import connectMongo from "@/utils/dbConnect";

// Função para obter todos os "todos"
export const getTodos = async (req) => {
  await connectMongo();
  try {
    const todos = await Todo.find({ userId: req.user.userId });
    return new Response(JSON.stringify({ todos }), {
      status: 200,
      headers: { "Content-Type": "application/json" },
    });
  } catch (error) {
    return new Response(JSON.stringify({ error: "Erro ao buscar tarefas" }), {
      status: 500,
      headers: { "Content-Type": "application/json" },
    });
  }
};

// Função para adicionar um novo "todo"
export const addTodo = async (req) => {
  const { titulo, descricao } = await req.json(); // A API nativa usa req.json() para corpo da requisição
  await connectMongo();
  try {
    const newTodo = new Todo({
      titulo,
      descricao,
      userId: req.user.userId,
    });
    await newTodo.save();
    return new Response(JSON.stringify({ todo: newTodo }), {
      status: 201,
      headers: { "Content-Type": "application/json" },
    });
  } catch (error) {
    return new Response(
      JSON.stringify({ message: "Erro ao adicionar tarefa" }),
      {
        status: 500,
        headers: { "Content-Type": "application/json" },
      }
    );
  }
};

// Função para atualizar um "todo"
export const updateTodo = async (req) => {
  const { id } = req.query;
  const data = await req.json();
  await connectMongo();

  try {
    const updatedTodo = await Todo.findOneAndUpdate(
      { _id: id, userId: req.user.userId },
      data,
      { new: true }
    );
    if (!updatedTodo) {
      return new Response(
        JSON.stringify({ message: "Tarefa não encontrada" }),
        {
          status: 404,
          headers: { "Content-Type": "application/json" },
        }
      );
    }
    return new Response(JSON.stringify({ todo: updatedTodo }), {
      status: 200,
      headers: { "Content-Type": "application/json" },
    });
  } catch (error) {
    return new Response(
      JSON.stringify({ message: "Erro ao atualizar a tarefa" }),
      {
        status: 500,
        headers: { "Content-Type": "application/json" },
      }
    );
  }
};

// Função para deletar um "todo"
export const deleteTodo = async (req) => {
  const { id } = req.query;
  await connectMongo();

  try {
    const deletedTodo = await Todo.findOneAndDelete({
      _id: id,
      userId: req.user.userId,
    });
    if (!deletedTodo) {
      return new Response(
        JSON.stringify({ message: "Tarefa não encontrada" }),
        {
          status: 404,
          headers: { "Content-Type": "application/json" },
        }
      );
    }
    return new Response(
      JSON.stringify({ message: "Tarefa deletada com sucesso" }),
      {
        status: 200,
        headers: { "Content-Type": "application/json" },
      }
    );
  } catch (error) {
    return new Response(JSON.stringify({ message: "Erro ao deletar tarefa" }), {
      status: 500,
      headers: { "Content-Type": "application/json" },
    });
  }
};
