<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateLoaiGhesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('loaighe', function (Blueprint $table) {
            $table->increments('id');
            $table->string('Tenloaighe');
            $table->integer('gia_id')->unsigned()->index();
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('gia_id')->references('id')->on('gia');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('loaighe');
    }
}
