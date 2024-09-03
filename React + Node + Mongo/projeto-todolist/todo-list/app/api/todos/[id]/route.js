import connectMongo from "@/utils/mongodb";
import Todo from "@/models/Todo";
import { NextResponse } from "next/server";

export async function PUT(req, { params }) {
  await connectMongo();
  try {
    const data = await req.json();
    const todo = await Todo.findByIdAndUpdate(params.id, data, {
      new: true,
      runValidators: true,
    });
    if (!todo) {
      return NextResponse.json({ success: false }, { status: 400 });
    }
    return NextResponse.json({ success: true, data: todo });
  } catch (error) {
    return NextResponse.json({ success: false }, { status: 400 });
  }
}

export async function DELETE(req,{ params }) {
  await connectMongo();
  try {
    const deletedTodo = await Todo.deleteOne({ _id: params.id });
    if (!deletedTodo) {
      return NextResponse.json({ success: false }, { status: 400 });
    }
    return NextResponse.json({ success: true, data: {} });
  } catch (error) {
    return NextResponse.json({ success: false }, { status: 400 });
  }
}
