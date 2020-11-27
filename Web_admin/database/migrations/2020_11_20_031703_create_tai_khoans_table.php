<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateTaiKhoansTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('taikhoan', function (Blueprint $table) {
            $table->increments('id');
            $table->string('Ten_TK')->unique();
            $table->string('HoTen');
            $table->string('Matkhau',16);
            $table->string('Email')->unique();
            $table->date('Ngaysinh');
            $table->string('Phai',5);
            $table->string('SDT',10)->unique();
            $table->string('Diachi');
            $table->timestamps();
            $table->softDeletes();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('taikhoan');
    }
}
